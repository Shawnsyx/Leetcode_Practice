package Easy;

public class Issue1576 {
  
  /**
   * 原来字符 'b' ++ 后就变成了'c'啊，学到了！
   * @author Yushaw
   *
   */
  class Solution {
    public String modifyString(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                //前面一个字符  如果当前是第0个的话 字符就为‘ ’
                char ahead = i == 0 ? ' ' : chars[i - 1];
                //后面一个字符  如果当前是最后一个的话 字符就为‘ ’
                char behind  = i == chars.length - 1 ? ' ' : chars[i + 1];
                //从a开始比较  如果等于前面或者后面的话 就+1
                char temp = 'a';
                while (temp == ahead || temp == behind ) {
                    temp++;
                }
                //找到目标字符后 做替换
                chars[i] = temp;
            }
        }
        return new String(chars);
    }
}  
  
  
  /** 
public static class solution{
  //从前面开始遍历，遇到问号就对比前面和后面的 用一个不与前面和后面一致的字符代替就好了

  * 狗屎版本-本人的
    public String modifyString(String s) {
      char[] charArray = s.toCharArray();
      StringBuilder answer = new StringBuilder();
      for(int i = 0;i < charArray.length; i++) {
        if(charArray[i]=='?') {
          if(charArray.length==1) {
            answer.append(getChar(charArray[i]));
            return answer.toString();
          }
          if(i==0) {
            charArray[i] = getChar(charArray[i+1]);
          }else if(i < charArray.length - 1) {
            charArray[i] = betweenChar(charArray[i-1], charArray[i+1]);
          }else {
            charArray[i] = getChar(charArray[i-1]);
          }
        }
        answer.append(charArray[i]);
      }
      return answer.toString();
    }
    
    public char getChar(char c) {
      //返回不同于c的
      String charRange = "qwertyuiopasdfghjklzxcvbnm";
      char[] range = charRange.toCharArray();
      char s;
      for(int i = 0;i < range.length; i++) {
        if(range[i]!=c) return range[i];
      }
      return range[range.length-1]; 
    }
    
    public char betweenChar(char a,char b) {
    //返回不同于c的
      String charRange = "qwertyuiopasdfghjklzxcvbnm";
      char[] range = charRange.toCharArray();
      char s;
      for(int i = 0;i < range.length; i++) {
        if(range[i]!=a && range[i] != b) return range[i];
      }
      return range[range.length-1]; 
    }
    
    public static void main(String[] args) {
      String s = "?sdfsd";
      solution s1 = new solution();
      System.out.println(s1.modifyString(s));
    }
 }
 **/

}
