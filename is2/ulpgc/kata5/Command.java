package is2.ulpgc.kata5;

public interface Command {
    Output execute(Input input);

    interface Input{
        String get(String param);
    }

    interface Output {
        int responseCode();

        String result();
    }

}
