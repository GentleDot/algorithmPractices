package howToSolve;

public class Quine {
    public static void main(String[] args) {
        // 큰따옴표를 string 내에서 표현하기 위해 ascii code 로 표현
        char quote = 34;
        // 각 행을 쉼표를 기준으로 분할해서 출력하기 위해 ascii code로 표현
        Character rest = 44;
        for (String str : strs.split(rest.toString())) {
            System.out.println(str);
        }
        // strs 문자열을 그대로 출력하기 위한 구문
        System.out.println(quote + strs + quote + '}');
    }
    static String strs =
"public class Quine {,    public static void main(String[] args) {,        // 큰따옴표를 string 내에서 표현하기 위해 ascii code 로 표현,        char quote = 34;,        // 각 행을 쉼표를 기준으로 분할해서 출력하기 위해 ascii code로 표현,        Character rest = 44;,        for (String str : strs.split(rest.toString())) {,                System.out.println(str);,        },        // strs 문자열을 그대로 출력하기 위한 구문,        System.out.println(quote + strs + quote + '}');,    },    static String strs =";}
