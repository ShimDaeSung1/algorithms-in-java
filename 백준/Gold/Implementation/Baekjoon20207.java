package Implementation;


//수현이는 일년의 날짜가 1일부터 365일로 표시되어있는 달력을 가지고있다. 수현이는 너무나도 계획적인 사람이라 올 해 일정을 모두 계획해서 달력에 표시해놨다. 
//
//여름이 거의 끝나가자 장마가 시작되었고, 습기로 인해 달력에 표시한 일정이 지워지려고 한다. 지워지는 것을 막고자 수현이는 일정이 있는 곳에만 코팅지를 달력에 붙이려고 한다. 
//하지만 너무 귀찮았던 나머지, 다음과 같은 규칙을 따르기로 한다.
//
//연속된 두 일자에 각각 일정이 1개 이상 있다면 이를 일정이 연속되었다고 표현한다.
//연속된 모든 일정은 하나의 직사각형에 포함되어야 한다. 
//연속된 일정을 모두 감싸는 가장 작은 직사각형의 크기만큼 코팅지를 오린다.
//달력은 다음과 같은 규칙을 따른다.
//
//일정은 시작날짜와 종료날짜를 포함한다.
//시작일이 가장 앞선 일정부터 차례대로 채워진다.
//시작일이 같을 경우 일정의 기간이 긴 것이 먼저 채워진다.
//일정은 가능한 최 상단에 배치된다.
//일정 하나의 세로의 길이는 1이다. 
//하루의 폭은 1이다. 
//
//
//위의 그림에서와 같이 일정이 주어졌다고 하자. 여기서 코팅지의 면적은 아래의 파란색 영역과 같다.
//
//
//
//이때 코팅지의 크기의 합은 3 x 8 + 2 x 2 = 28이다. 
//
//일정의 개수와 각 일정의 시작날짜, 종료날짜가 주어질 때 수현이가 자르는 코팅지의 면적을 구해보자.
//
//입력
//첫째 줄에 일정의 개수 N이 주어진다. (1 ≤ N ≤ 1000)
//
//둘째 줄부터 일정의 개수만큼 시작 날짜 S와 종료 날짜 E가 주어진다. (1 ≤ S ≤ E ≤ 365)
//
//출력
//코팅지의 면적을 출력한다.
//
//예제 입력 1 
//7
//2 4
//4 5
//5 6
//5 7
//7 9
//11 12
//12 12
//예제 출력 1 
//28
//예제 입력 2 
//5
//1 9
//8 9
//4 6
//3 4
//2 5
//예제 출력 2 
//36
import java.io.*;
import java.util.*;
public class Practice20207 {
	
	static int n;
	static int[][] calender;
	static int answer = 0;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		calender = new int[n][2];
		
		for(int i = 0 ; i<n; i++) {
			String[] se = br.readLine().split(" ");
			calender[i][0] = Integer.valueOf(se[0]);
			calender[i][1] = Integer.valueOf(se[1]);
		}
		
		Arrays.sort(calender, (o1,o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
		
		int[] graph = new int[366];
		
		for(int i = 0; i<n; i++) { // 1000
			int[] schedule = calender[i];
			
			int start = schedule[0];
			int end = schedule[1];
			
			for(int j = start; j<end+1; j++) {
				graph[j]++;
			}
			
		}

		int height = 0;
		int len = 0;
		for(int i = 1; i<366; i++) {
			if(graph[i] == 0) {
				answer += height*(len);
				height = 0;
				len = 0;
			}else {
				height = Math.max(height, graph[i]);
				len += 1;
			}
		}
		
		answer += height*len;
		
		System.out.println(answer);
	}

}
