package leetcode;

//https://leetcode.com/problems/defanging-an-ip-address/
class defangIPaddr {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "\\[\\.\\]");
    }
}
