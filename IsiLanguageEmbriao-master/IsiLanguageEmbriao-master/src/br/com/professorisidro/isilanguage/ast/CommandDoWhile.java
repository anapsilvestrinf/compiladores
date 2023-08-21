package src.br.com.professorisidro.isilanguage.ast;

import java.util.ArrayList;

public class CommandDoWhile extends AbstractCommand {

    private String condicao;
    private ArrayList<AbstractCommand> comandos;

    public CommandDoWhile(String condicao, ArrayList<AbstractCommand> comandos)
    {
        this.condicao = condicao;
        this.comandos = comandos;
    }

    @Override
    public String generateJavaCode() {

        StringBuilder str = new StringBuilder();



        str.append("do {\n");
        for(AbstractCommand cmd : comandos) {
            str.append(cmd.generateJavaCode());
        }
        str.append("\n} while ("+condicao+");");
        return str.toString();

    }

    @Override
    public String toString() {
        return "CommandEnquanto [faça=" + comandos + ", loopCondition " + condicao
                + "]";
    }

}