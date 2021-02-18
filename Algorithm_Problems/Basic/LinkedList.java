public class LinkedList{

    public static class NodeList{
        private NodeList link;
        public String data;

        NodeList(){
            this.link = null;
            this.data = null;
        }

        NodeList(String data){
            this.data = data;
            this.link = null;
        }

        NodeList(String data , NodeList link){
            this.data = data;
            this.link = link;
        }

        public String getData(){
            return this.data;
        }
        // 1 addNode
        public void addNode(String data){
            NodeList head = this;
            
        }
    }
    public static void main(String[] args) {
        
        NodeList list = new NodeList("mon");
        System.out.println(list.getData());
    }
}