import java.io.*;
import java.util.*;

/*
Minimum Number Of Software Developers - bit manipulation

Input Format
A number N representing number of required skills
N space separated strings 
A number M representing number of applicants
For every applicant : A number T representing number of skills of an applicant and then T number of space separated strings.

Output Format
An arraylist containing the indices of selected applicants.

Sample Input
3
java nodejs reactjs
3
1
java
1
nodejs
2
nodejs
reactjs

Sample Output
[0, 2]

time: O(2^n)
space: O(n)
*/

public class Min_nos_of_softwareDevelopers {

	static ArrayList<Integer> sol = new ArrayList<>();
    
	public static void solution(int[] people, int nskills, int cp, ArrayList<Integer> onesol, int skills) {
	    if(cp==people.length) {
	        if(skills == (1<<nskills) -1) {
	            if(sol.size()==0 || onesol.size()< sol.size())
	                sol = new ArrayList<>(onesol);
	        }
	        return;
	    }
	    
		solution(people, nskills, cp+1, onesol, skills);
		onesol.add(cp);
		solution(people, nskills, cp+1, onesol, (skills | people[cp]));
		onesol.remove(onesol.size()-1);
		
	}
	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(new FileReader("../input"));
		int n = scn.nextInt();
		HashMap<String, Integer> smap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			smap.put(scn.next(), i);
		}
		
		int np = scn.nextInt();
		int[] people = new int[np];
		for (int i = 0; i < np; i++) {
			int personSkills = scn.nextInt();
			for (int j = 0; j < personSkills; j++) {
				String skill = scn.next();
				int snum = smap.get(skill);
				people[i] = people[i] | (1 << snum);
			}
		}

		solution(people, n, 0, new ArrayList<>(), 0);
		System.out.println(sol);
		
	}
}