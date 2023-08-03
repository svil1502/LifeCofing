public class TipesOfClasses {

    public static void main(String[] args) {


    MonitoringSystem generalModule = new MonitoringSystem() {

        @Override
        public void startMonitoring() {
            System.out.println("Общий мониторинг");
        }
        public void someSpecificMethod() {
            System.out.println("Специфический метод");
        }


    };
    MonitoringSystem errorModule = new MonitoringSystem() {
        @Override
        public void startMonitoring() {
            System.out.println("Мониторинг ошибок");
        }
    };

   generalModule.startMonitoring();
   //generalModule.someSpecificMethod();

}

}