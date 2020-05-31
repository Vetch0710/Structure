package com.Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Greedy {
//贪心算法 解决广播覆盖问题
	public static void main(String[] args) {
	//存放所有广播电台
    HashMap<String, HashSet<String>>  broad=new HashMap<String, HashSet<String>>();
    
    HashSet<String> h1=new HashSet<String>();
    h1.add("北京");
    h1.add("上海");
    h1.add("天津");
    HashSet<String> h2=new HashSet<String>();
    h2.add("成都");
    h2.add("上海");
    h2.add("天津");
    HashSet<String> h3=new HashSet<String>();
    h3.add("广州");
    h3.add("深圳");
    HashSet<String> h4=new HashSet<String>();
    h4.add("大连");
    h4.add("天津");
    HashSet<String> h5=new HashSet<String>();
    h5.add("大连");
    h5.add("杭州");
    
    broad.put("K1", h1);
    broad.put("K2", h2);
    broad.put("K3", h3);
    broad.put("K4", h4);
    broad.put("K5", h5);
    
    //存放所有地区   [成都, 大连, 杭州]
    HashSet<String> Allareas=new HashSet<String>();
    Allareas.addAll(h1);
    Allareas.addAll(h2);
    Allareas.addAll(h3);
    Allareas.addAll(h4);
    Allareas.addAll(h5);
    System.out.println(Allareas);
    //存放选择的电台
    ArrayList<String> selects=new  ArrayList<String>();
    
    HashSet<String> tempset=new HashSet<String>();
    HashSet<String> tempset2=new HashSet<String>();
    
    //保存 每次最优解的 答案
    String maxKey=null;
//    int count=0;
    while(Allareas.size()!=0) {
    	maxKey=null;
    	
    	for (String key:broad.keySet()) {
    		tempset.clear();
    		tempset2.clear();
    		//取出当前电台 所覆盖的地区
    		 HashSet<String> areas=broad.get(key);
    		 //将地区放入临时集合中
    		 tempset.addAll(areas);
    		 //求出当前电台 所覆盖的地区  和  所有地区 的交集  ，并放入集合中
    		 tempset.retainAll(Allareas);
    		 //计算之前 最优解的电台  所覆盖地区 的 数量
    		 if (maxKey!=null) {
    			 tempset2.addAll(broad.get(maxKey));
    			 tempset2.retainAll(Allareas);
//    			 System.out.println(tempset2.size());
			}
 
//    		 if (tempset.size()>0 &&(maxKey==null || tempset.size()> broad.get(maxKey).size())) {
//    			 maxKey=key;
//			}
    		 if (tempset.size()>0 &&(maxKey==null || tempset.size()> tempset2.size())) {
    			 maxKey=key;
    		 }
		}
    	System.out.println(maxKey);
    	if (maxKey!=null) {
			selects.add(maxKey);
			Allareas.removeAll(broad.get(maxKey));
		}
    
    }
    
    System.out.println(selects);
    
    
    
    
    
    
    
    
    
    
    
    
    
	}
	
}
