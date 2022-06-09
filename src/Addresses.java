public class Addresses {
    final int requiredLen = 4;
    String[] address = new String[requiredLen];
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
}