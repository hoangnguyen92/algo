package problemsolver;

import java.util.*;

public class TopologicalSort {

    Stack<Node> stack;

    public TopologicalSort() {
        stack=new Stack<>();
    }
    static class Node
    {
        int data;
        boolean visited;
        List<Node> neighbours;

        Node(int data)
        {
            this.data=data;
            this.neighbours=new ArrayList<>();

        }
        public void addneighbours(Node neighbourNode)
        {
            this.neighbours.add(neighbourNode);
        }
        public List<Node> getNeighbours() {
            return neighbours;
        }
        public void setNeighbours(List<Node> neighbours) {
            this.neighbours = neighbours;
        }
        public String toString()
        {
            return ""+data;
        }
    }

    // Recursive toplogical Sort
    public  void toplogicalSort(Node node)
    {
        List<Node> neighbours=node.getNeighbours();
        for (int i = 0; i < neighbours.size(); i++) {
            Node n=neighbours.get(i);
            if(n!=null && !n.visited)
            {
                toplogicalSort(n);
                n.visited=true;
            }
        }
        stack.push(node);
    }

    public static void main(String arg[])
    {

        TopologicalSort topological = new TopologicalSort();
        Node node40 =new Node(40);
        Node node10 =new Node(10);
        Node node20 =new Node(20);
        Node node30 =new Node(30);
        Node node60 =new Node(60);
        Node node50 =new Node(50);
        Node node70 =new Node(70);
        Node node80 =new Node(80);
        Node node90 =new Node(90);

        node40.addneighbours(node10);
        node40.addneighbours(node20);
        node10.addneighbours(node30);
        node20.addneighbours(node10);
        node20.addneighbours(node30);
        node20.addneighbours(node60);
        node20.addneighbours(node50);
        node30.addneighbours(node60);
        node60.addneighbours(node70);
        node50.addneighbours(node70);

        node80.addneighbours(node90);

        System.out.println("Topological Sorting Order:");
        for(Node n : Arrays.asList(node10,node20,node30,node40,node50,node60,node70,node80,node90)){
            if(!n.visited)
                topological.toplogicalSort(n);
        }


        // Print contents of stack
        Stack<Node> resultStack=topological.stack;
        while (!resultStack.empty())
            System.out.print(resultStack.pop() + " ");
    }

}
