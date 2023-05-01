public class SearchResults{
    private PoliceActivity[] rows;
    
    
    

    public String toString() {
      String result = "";
      for (PoliceActivity s : this.rows){
      result += s.toString() + "\n";
       
        }
      return result;  
    }
}