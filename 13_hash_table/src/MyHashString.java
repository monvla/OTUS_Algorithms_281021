class MyHashString {

    MyHashString(String value) {
        this.value = value;
    }

    private String value;

    @Override
    public int hashCode() {
        int hashCode = 0;
        for (int i = 0; i < value.length(); i++){
            int code = value.charAt(i);
            hashCode += code;
        }
        return hashCode;
    }
}