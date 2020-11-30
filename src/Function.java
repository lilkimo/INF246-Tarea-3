public class Function {
    public Character parameter;
    public String equation;

    public Function(Character parameter, String equation) {
        this.parameter = parameter;
        this.equation = equation;
    }

    public String toString() {
        return parameter + ", " + equation;
    }
}
