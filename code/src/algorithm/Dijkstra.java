package algorithm;

import java.util.Arrays;

class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        // �����ڽӱ����ڴ�Ÿ����㵽������ľ���
        int[][] graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                graph[i][j] = -1;
            }
        }
        // ����times����ڽӱ�
        for (int[] time : times) {
            graph[time[0]][time[1]] = time[2];
        }

        // ��� K ������������·���������Ǹ����·����Ϊ���
        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1);

        // ��ʼ�� distance Ϊ K �������ڵ�ľ���
        for (int i = 1; i <= N; i++) {
            distance[i] = graph[K][i];
        }
        // K����K����Ľڵ��ʼ��Ϊ 0
        distance[K] = 0;

        // �ж��Ƿ��ҵ�K����õ����·��
        boolean[] visited = new boolean[N + 1];
        visited[K] = true;

        // ������K����ڵ�֮�������N-1���ڵ�
        for (int i = 1; i <= N - 1; i++) {
            int minDistance = Integer.MAX_VALUE;
            int minIndex = 1;
            // �������нڵ㣬�ҵ���K����Ľڵ�
            for (int j = 1; j <= N; j++) {
                if (!visited[j] && distance[j] != -1 && distance[j] < minDistance) {
                    minDistance = distance[j];
                    minIndex = j;
                }
            }

            // ����������ڵ��ҵ�
            visited[minIndex] = true;

            // ���ݸո��ҵ�����̾���ڵ㣬ͨ���ýڵ����K�ڵ��������Ľڵ�ľ���
            for (int j = 1; j <= N; j++) {
                // ����Ѹ��µ���̽ڵ���Ե��ﵱǰ�ڵ�
                if (graph[minIndex][j] != -1) {
                    if (distance[j] != -1) {
                        // ȡ֮ǰ·���뵱ǰ����·������Сֵ
                        distance[j] = Math.min(distance[j], distance[minIndex] + graph[minIndex][j]);
                    } else {
                        // �ýڵ��ǵ�һ�η��ʣ�ֱ�Ӹ���
                        distance[j] = distance[minIndex] + graph[minIndex][j];
                    }
                }
            }
        }

        int maxDistance = 0;
        // �������ֵ������нڵ�δ�����ʣ����� -1�����򷵻�������·��
        for (int i = 1; i <= N; i++) {
            if (distance[i] == -1) {
                return -1;
            }
            maxDistance = Math.max(distance[i], maxDistance);
        }

        return maxDistance;
    }
}

���ߣ�hncboy
���ӣ�https://leetcode-cn.com/problems/network-delay-time/solution/java-shi-xian-dijkstra-floyd-bellman-ford-spfa-by-/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
/*

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {

	public static void main(String[] args) {
		Graph g = new Graph();
		g.addVertex('A', Arrays.asList(new Vertex('B', 7), new Vertex('C', 8)));
		g.addVertex('B', Arrays.asList(new Vertex('A', 7), new Vertex('F', 2)));
		g.addVertex('C', Arrays.asList(new Vertex('A', 8), new Vertex('F', 6), new Vertex('G', 4)));
		g.addVertex('D', Arrays.asList(new Vertex('F', 8)));
		g.addVertex('E', Arrays.asList(new Vertex('H', 1)));
		g.addVertex('F', Arrays.asList(new Vertex('B', 2), new Vertex('C', 6), new Vertex('D', 8), new Vertex('G', 9), new Vertex('H', 3)));
		g.addVertex('G', Arrays.asList(new Vertex('C', 4), new Vertex('F', 9)));
		g.addVertex('H', Arrays.asList(new Vertex('E', 1), new Vertex('F', 3)));
		System.out.println(g.getShortestPath('A', 'H'));
	}
	
}

class Vertex implements Comparable<Vertex> {
	
	private Character id;
	private Integer distance;
	
	public Vertex(Character id, Integer distance) {
		super();
		this.id = id;
		this.distance = distance;
	}

	public Character getId() {
		return id;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setId(Character id) {
		this.id = id;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (distance == null) {
			if (other.distance != null)
				return false;
		} else if (!distance.equals(other.distance))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vertex [id=" + id + ", distance=" + distance + "]";
	}

	@Override
	public int compareTo(Vertex o) {
		if (this.distance < o.distance)
			return -1;
		else if (this.distance > o.distance)
			return 1;
		else
			return this.getId().compareTo(o.getId());
	}
	
}

class Graph {
	
	private final Map<Character, List<Vertex>> vertices;
	
	public Graph() {
		this.vertices = new HashMap<Character, List<Vertex>>();
	}
	
	public void addVertex(Character character, List<Vertex> vertex) {
		this.vertices.put(character, vertex);
	}
	
	public List<Character> getShortestPath(Character start, Character finish) {
		final Map<Character, Integer> distances = new HashMap<Character, Integer>();
		final Map<Character, Vertex> previous = new HashMap<Character, Vertex>();
		PriorityQueue<Vertex> nodes = new PriorityQueue<Vertex>();
		
		for(Character vertex : vertices.keySet()) {
			if (vertex == start) {
				distances.put(vertex, 0);
				nodes.add(new Vertex(vertex, 0));
			} else {
				distances.put(vertex, Integer.MAX_VALUE);
				nodes.add(new Vertex(vertex, Integer.MAX_VALUE));
			}
			previous.put(vertex, null);
		}
		
		while (!nodes.isEmpty()) {
			Vertex smallest = nodes.poll();
			if (smallest.getId() == finish) {
				final List<Character> path = new ArrayList<Character>();
				while (previous.get(smallest.getId()) != null) {
					path.add(smallest.getId());
					smallest = previous.get(smallest.getId());
				}
				return path;
			}

			if (distances.get(smallest.getId()) == Integer.MAX_VALUE) {
				break;
			}
						
			for (Vertex neighbor : vertices.get(smallest.getId())) {
				Integer alt = distances.get(smallest.getId()) + neighbor.getDistance();
				if (alt < distances.get(neighbor.getId())) {
					distances.put(neighbor.getId(), alt);
					previous.put(neighbor.getId(), smallest);
					
					forloop:
					for(Vertex n : nodes) {
						if (n.getId() == neighbor.getId()) {
							nodes.remove(n);
							n.setDistance(alt);
							nodes.add(n);
							break forloop;
						}
					}
				}
			}
		}
		
		return new ArrayList<Character>(distances.keySet());
	}
	
}*/