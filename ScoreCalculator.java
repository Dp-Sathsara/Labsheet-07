public class ScoreCalculator {
    private class Node {
        String name;
        int score;
        int time;
        Node next;
        
        public Node(String name, int score, int time) {
            this.name = name;
            this.score = score;
            this.time = time;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public ScoreCalculator(){
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void insertLast(String name, int score, int time){
        Node newNode = new Node(name, score, time);
        if(isEmpty()){
            head = newNode;
        }else{
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public int ListSize(){
        return size;
    }

    public void traverseList(){
        if(isEmpty()){
            System.out.println("List is empty");
        }else{
            Node current = head;
            System.out.println("Participant\tScore\tTime (minutes)");
            while (current != null) {
                System.out.println(current.name + "\t\t" + current.score + "\t" + current.time );
                current = current.next;
            }
            System.out.println("");
        }
    }

    public String getHighestScorer(){
        if(isEmpty()){
            return "List is empty";
        }else{
            Node current = head;
            Node highestScorer = head;
            while (current != null) {
                if(current.score > highestScorer.score){
                    highestScorer = current;
                }
                current = current.next;
            }
            return highestScorer.name + " with a score of " + highestScorer.score;
        }
    }

    public String getFastestParticipant(){
        if(isEmpty()){
            return "List is empty";
        }else{
            Node current = head;
            Node fastestParticipant = head;
            while (current != null) {
                if(current.time < fastestParticipant.time){
                    fastestParticipant = current;
                }
                current = current.next;
            }
            return fastestParticipant.name + " with a time of " + fastestParticipant.time + " minutes";
        }
    }
    public void displayEfficiency(){
        if(isEmpty()){
            System.out.println("List is empty");
        }else{
            Node current = head;
            System.out.println("Participant\tEfficiency");
            while (current != null) {
                double efficiency = (double) current.score / current.time;
                System.out.println(current.name + "\t\t" + efficiency);
                current = current.next;
            }
            System.out.println("");
        }
    }
    public String getMostEfficientParticipant() {
        if(isEmpty()){
            return "List is empty";
        } else {
            Node current = head;
            Node mostEfficient = head;
            double highestEfficiency = (double) head.score / head.time;
            while (current != null) {
                double currentEfficiency = (double) current.score / current.time;
                if (currentEfficiency > highestEfficiency) {
                    highestEfficiency = currentEfficiency;
                    mostEfficient = current;
                }
                current = current.next;
            }
            return mostEfficient.name + " with an efficiency of " + highestEfficiency;
        }
    }

    public static void main(String[] args) {
        ScoreCalculator Slist = new ScoreCalculator();
        Slist.insertLast("Bob", 35, 40);
        Slist.insertLast("Diana", 94, 57);
        Slist.insertLast("Jon", 90, 60);
        Slist.insertLast("Mary", 56, 49);
        Slist.insertLast("Charlie", 87, 52);

        Slist.traverseList();
        System.out.println("(02) a)-------Answer");
        System.out.println("Highest score: " + Slist.getHighestScorer());
        System.out.println("");
        System.out.println("(02) b)-------Answer");
        System.out.println("");
        System.out.println("Fastest completion time: " + Slist.getFastestParticipant());
        System.out.println("");
        System.out.println("(02) c)-------Answer");
        System.out.println("");
        Slist.displayEfficiency();
        System.out.println("");
        System.out.println("(02) d)-------Answer");
        System.out.println("");
        System.out.println("Most efficient participant: " + Slist.getMostEfficientParticipant());
        System.out.println("");
    }
}
