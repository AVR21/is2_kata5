package is2.ulpgc.kata5;

public class CommandFactorial implements Command{

    @Override
    public Output execute(Input input) {
        try {
            int num = Integer.parseInt(input.get(":num"));
            return isOutOfBounds(num) ? outOfBounds() : result(num);
        } catch (NumberFormatException e) {
            return nanNum();
        }
    }

    private Output result(int num){
        return new Output() {
            @Override
            public int responseCode() {
                return 200;
            }

            @Override
            public String result() {
                return String.valueOf(factorial(num));
            }
        }
    }

    private Output nanNum(){
        return new Output() {
            @Override
            public int responseCode() {
                return 405;
            }

            @Override
            public String result() {
                return "El valor introducido no se reconoce como numérico.";
            }
        };
    }

    private boolean isOutOfBounds(int num){
        return num < 1;
    }

    private Output outOfBounds(){
        return new Output() {
            @Override
            public int responseCode() {
                return 403;
            }

            @Override
            public String result() {
                return "El valor no puede ser menor que 1.";
            }
        };
    }

    private static int factorial(int num){
        if(num == 0)
            return 1;
        else
            return (num * factorial(num-1));
    }

}
