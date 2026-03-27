import java.util.*;
class dfsList{
	static void dfs(int s, List<Integer>[] g, boolean[] v){
		v[s]=true;
		System.out.println();
		System.out.print(s+"");
		for(int i=0; i<n; i++){
			if(!v[nb]){
				dfs(nb, g, v);
			}
		}
	}
	public static void main(String[] args){
		int n = 5;
		@SuppressWarnings("unchecked");
		List<Integer>[] g = new ArrayList[5];
		for(int i=0; i<n; i++)g[i]=new ArrayList<>();
		g[0].add(3);
		g[0].add(4);
		g[1].add(2);
		g[1].add(3);
		g[2].add(4);
		g[2].add(3);
		g[2].add(1);
		g[3].add(1);
		g[3].add(0);
		g[3].add(2);
		g[4].add(2);
		g[4].add(0);
		System.out.println("Abj list");
		for(int i=0; i<n; i++){
			System.out.print(i+"->");
			for(int nb : g[i]){
				System.out.print(nb+" ");
			}
			System.out.println();	
		}
	}
}