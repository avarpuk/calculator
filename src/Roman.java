public enum Roman {
    I(1), V(5), X(10);

    private int arabic;

    Roman(int arabic){
        this.arabic = arabic;
    }

    public int getArabic(){
        return arabic;
    }
}
