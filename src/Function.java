public class Function {
    private Character parameter;
    private String equation;

    public Function(Character parameter, String equation) {
        this.parameter = parameter;
        this.equation = equation;
    }

    public String toString() {
        return parameter + ", " + equation;
    }

    public Character getparameter() {
        return parameter;
    }
    
    public String getequation() {
        return equation;
    }
    
}
