public class The_geom {
  private String type;
  private String wkbtype;
  private float dims;
  private float srid;


 // Getter Methods 

  public String getType() {
    return type;
  }

  public String getWkbtype() {
    return wkbtype;
  }

  public float getDims() {
    return dims;
  }

  public float getSrid() {
    return srid;
  }

 // Setter Methods 

  public void setType( String type ) {
    this.type = type;
  }

  public void setWkbtype( String wkbtype ) {
    this.wkbtype = wkbtype;
  }

  public void setDims( float dims ) {
    this.dims = dims;
  }

  public void setSrid( float srid ) {
    this.srid = srid;
  }
}
