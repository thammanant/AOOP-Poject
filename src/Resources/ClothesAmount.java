package Resources;

public class ClothesAmount {
    private final ClothesType[] clothes;
    private final int[] amount;
    private int size;

    public ClothesAmount() {
        clothes = new ClothesType[100];
        amount = new int[100];
        size = 0;
    }

    public void addWord(ClothesType word, int definition) {
        for (int i = 0; i < size; i++) {
            if (clothes[i] == word) {
                amount[i] += definition;
                return;
            }
        }
        clothes[size] = word;
        amount[size] = definition;
        size++;
    }

    public void remove(ClothesType word) {
        for (int i = 0; i < size; i++) {
            if (clothes[i] == word) {
                amount[i]--;
                if (amount[i] == 0) {
                    for (int j = i; j < size - 1; j++) {
                        clothes[j] = clothes[j + 1];
                        amount[j] = amount[j + 1];
                    }
                    size--;
                }
                return;
            }
        }
    }

    public String printAll() {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += clothes[i].getName() + " " + amount[i] + " " + clothes[i].getColour() + "\n";
        }
        return result;
    }
    //print amount by index
    public int printAmount(int i){
        return amount[i];
    }
    public int printTotal(){
        int res =0;
        for(int i=0;i<size;i++){
            res += amount[i];
        }
        return res;
    }
    public int getSize() {
        return this.size;
    }

}

