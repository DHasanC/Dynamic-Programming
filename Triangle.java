class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        
        List<List<Integer>> temp = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(triangle.get(0).get(0));
        temp.add(a);
        for(int i = 1; i < triangle.size(); i++){
            List<Integer> layer = new ArrayList<>();
            for(int j = 0; j < triangle.get(i).size(); j++){
                if(j == 0) layer.add(temp.get(i - 1).get(0) + triangle.get(i).get(j));
                else if(j == triangle.get(i).size() - 1) layer.add(temp.get(i - 1).get(triangle.get(i - 1).size() - 1) + triangle.get(i).get(j));
                else layer.add(Math.min(temp.get(i - 1).get(j), temp.get(i - 1).get(j - 1)) + triangle.get(i).get(j));
            }
            temp.add(layer);
        }
        System.out.println(temp);
        return Collections.min(temp.get(temp.size() - 1));
    }
}
