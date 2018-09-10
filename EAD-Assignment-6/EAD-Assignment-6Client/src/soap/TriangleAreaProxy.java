package soap;

public class TriangleAreaProxy implements soap.TriangleArea {
  private String _endpoint = null;
  private soap.TriangleArea triangleArea = null;
  
  public TriangleAreaProxy() {
    _initTriangleAreaProxy();
  }
  
  public TriangleAreaProxy(String endpoint) {
    _endpoint = endpoint;
    _initTriangleAreaProxy();
  }
  
  private void _initTriangleAreaProxy() {
    try {
      triangleArea = (new soap.TriangleAreaServiceLocator()).getTriangleArea();
      if (triangleArea != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)triangleArea)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)triangleArea)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (triangleArea != null)
      ((javax.xml.rpc.Stub)triangleArea)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public soap.TriangleArea getTriangleArea() {
    if (triangleArea == null)
      _initTriangleAreaProxy();
    return triangleArea;
  }
  
  public double getAreaOfTriangle(double sideA, double sideB, double sideC) throws java.rmi.RemoteException{
    if (triangleArea == null)
      _initTriangleAreaProxy();
    return triangleArea.getAreaOfTriangle(sideA, sideB, sideC);
  }
  
  
}