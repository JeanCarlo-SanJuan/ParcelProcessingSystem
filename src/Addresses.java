public class Addresses {
    final int requiredLen = 4;
    public String[] address = new String[requiredLen];
    public Addresses(String[] AddressList) throws IllegalArgumentException{
        if (AddressList.length < requiredLen) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < requiredLen; i++) {
            address[i] = AddressList[i];
        }
    }

    public String get(int i) {
        return address[i];
    }

    public String toString() {
        String accumulator = "";        
        for (int i = 0; i < 4; i++) {
            accumulator += "Line " + (i + 1) + ": " + this.address[i] + "\n";
        }

        return accumulator;
    }
}