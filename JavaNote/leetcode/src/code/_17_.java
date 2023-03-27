package code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘佳俊
 */
public class _17_ {
    public List<String> letterCombinations(String digits) {

        List<List<Character>> list = new ArrayList<>();
        
        List<String> result = new ArrayList<>();

        for (char c : digits.toCharArray()) {
            List<Character> characters = numberToChars(c);
            list.add(characters);
        }

        return null;

    }

    public String process(List<String> result,List<List<Character>> list,int listIndex,int charIndex){
        List<Character> characters = list.get(listIndex);
        if(characters==null){
            return "";
        }

        for (Character character : characters) {
            String s = character + process(result, list, listIndex + 1, charIndex);
        }

        return null;
    }



    public List<Character> numberToChars(char c) {
        List<Character> list = new ArrayList<>();
        switch (c) {
            case '2':
                list.add('a');
                list.add('b');
                list.add('c');
                break;
            case '3':
                list.add('d');
                list.add('e');
                list.add('f');
                break;
            case '4':
                list.add('g');
                list.add('h');
                list.add('i');
                break;
            case '5':
                list.add('j');
                list.add('k');
                list.add('l');
                break;
            case '6':
                list.add('m');
                list.add('n');
                list.add('o');
                break;
            case '7':
                list.add('p');
                list.add('q');
                list.add('r');
                list.add('s');
                break;
            case '8':
                list.add('t');
                list.add('u');
                list.add('v');
                break;
            case '9':
                list.add('w');
                list.add('x');
                list.add('y');
                list.add('z');
                break;

        }
        return list;
    }

}
