public class PoliceActivity {
    private String dispatch_date_time;
    private String dc_key;
    private String location_block;

    public PoliceActivity() {
    }

    public void setLocation_block(String location_block) {
        this.location_block = location_block;
    }
    
   
    public void setDispatch_date_time(String dispatch_date_time) {
        this.dispatch_date_time = dispatch_date_time;
    }

    public void setDc_key(String dc_key) {
        this.dc_key = dc_key;
    }

    public String getDc_key() {
        return dc_key;
    }

  
    public String getLocation_block() {
        return location_block;
    }

    public String getDispatch_date_time() {
      return dispatch_date_time;
    }


    public String toString() {
        return "Police Activity: " + "dispatch date time = " + dispatch_date_time + ", dc_key = " + dc_key + ", location_block = " + location_block;
    }
}