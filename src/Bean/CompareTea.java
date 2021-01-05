package Bean;

import utils.TimeConverter;

public class CompareTea implements Comparable<CompareTea>{
    private String date;

    public CompareTea(){

    }

    public CompareTea(String date){
        super();
        this.date=date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int compareTo(CompareTea o) {
        long i = TimeConverter.getDate(this.getDate()).getTime() - TimeConverter.getDate(o.getDate()).getTime();
        if (i == 0) {
            return 0;
        } else if (i > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
