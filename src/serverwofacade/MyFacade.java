package serverwofacade;

public class MyFacade {
    private static MyFacade myFacadeObj = null;
    private MyFacade() {}
    public static MyFacade getMyFacadeObject() {
        if (myFacadeObj == null) {
            myFacadeObj = new MyFacade();
        }
        return myFacadeObj;
    }
    ScheduleServer scheduleServer = new ScheduleServer();
    public void startServer(){
        scheduleServer.startBooting();
        scheduleServer.readSystemConfigFile();
        scheduleServer.init();
        scheduleServer.initializeContext();
        scheduleServer.initializeListeners();
        scheduleServer.createSystemObjects();
        scheduleServer.releaseProcesses();
    }
    public void downServer(){
        scheduleServer.destory();
        scheduleServer.destroySystemObjects();
        scheduleServer.destoryListeners();
        scheduleServer.destoryContext();
        scheduleServer.shutdown();
    }
}
