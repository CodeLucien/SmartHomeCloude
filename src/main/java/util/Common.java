package util;

public class Common {

    public enum Result{
        //成功,失败
        //规范要求大写
        FALL(0), SUCCESS(1);  //有限的
        public int id;
        Result(int i) {
            this.id=i;
        }
    }

}
