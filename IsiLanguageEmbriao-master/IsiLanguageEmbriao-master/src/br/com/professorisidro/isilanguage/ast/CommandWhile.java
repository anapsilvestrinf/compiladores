package src.br.com.professorisidro.isilanguage.ast;

import java.util.ArrayList;

public class CommandWhile extends AbstractCommand{

    private String condicao;
    private ArrayList<AbstractCommand> comandos;

    public CommandWhile(String condicao, ArrayList<AbstractCommand> comandos)
    {
        this.condicao = condicao;
        this.comandos = comandos;
    }

    @Override
    public String generateJavaCode() {

        StringBuilder str = new StringBuilder();
        str.append("while ("+condicao+") {\n");
        for(AbstractCommand cmd : comandos) {
            str.append(cmd.generateJavaCode());
        }
        str.append("}\n");
        return str.toString();
    }

    @Override
    public String toString() {
        return "CommandWhile [condition=" + condicao + ", loopCommands" + comandos
                + "]";
    }

}
