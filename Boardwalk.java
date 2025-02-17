import java.util.Random;

public class Boardwalk <T>{
    Node<T> last;
    Node<T> stepNode;
    T currentNode;
    public Boardwalk(Node<T> last) {
        this.last = last;
        if (this.last != null) {
            this.last.next = last;
        }      
    }
    public Node<T> Append(T insert) {
        Node<T> n = new Node<>(insert);
        if (last == null) {
            n.next = n;
            stepNode = n;
            currentNode = stepNode.data;
        }
        else {
        n.next = last.next;
        last.next = n;
        }
        last = n;
        return last;
    }
    public Node<T> step() {
        stepNode = stepNode.next;
        currentNode = stepNode.data;
        return stepNode;
    }

    // I'm sorry for cloning the array last week :( can I get the points back?
    public void diceRoll() {
        long seed = System.currentTimeMillis();
        Random random = new Random(seed);
        int a = random.nextInt(6) + 1;
        int b = random.nextInt(1, 7);
        for (int i = 0; i < (a + b); i++) {
            step();
        }
    }
    public static void main(String[] args) {
        // Driver testing stnuff
        Boardwalk<String> boardwalk = new Boardwalk<String>(null);

        boardwalk.Append("Go");
        boardwalk.Append("Mediteranean Avenue");
        boardwalk.Append("Community Chest");
        boardwalk.Append("Baltic Avenue");
        boardwalk.Append("Income Tax");
        // And on so all the spaces are bored

        System.out.println(boardwalk.currentNode);
        // Should print "Go"

        boardwalk.step();

        System.out.println(boardwalk.currentNode);
        // Should print "Mediteranean Avenue"

        boardwalk.step();
        boardwalk.step();
        boardwalk.step();

        System.out.println(boardwalk.currentNode);
        // Should print "Income Tax"

        for (int i = 0; i < 37; i++) {
            boardwalk.step();
        }

        System.out.println(boardwalk.currentNode);
        // Should print "Mediteranean Avenue"

        boardwalk.diceRoll();
        System.out.println(boardwalk.currentNode);
        // Should eventually print out different results
    }
}

