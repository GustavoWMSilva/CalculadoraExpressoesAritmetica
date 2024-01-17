import java.util.ArrayList;
public class Resolucao{
    

    public String fechado(String c){
        if("}".equals(c)){
            return "{";
        } else 
        if("]".equals(c)){
            return "[";
        } else  if(")".equals(c)){
            return "(";
        }
        return "erro";
        
        
    }
    public String abriu2(String c){
        if("{".equals(c)){
            return "}";
        } else 
        if("[".equals(c)){
            return "]";
        } else  if("(".equals(c)){
            return ")";
        }
        return "erro";
        
        
    }


    
    public void codigo(String [] v){

        PilhaEncadeada p = new PilhaEncadeada();
        ArrayList expressao = new ArrayList<>(); //para printar a expressao analisada

        int tamanho = 0; //tamanho maximo da p
        double resultado = 0; //reusltado da ultima operaçao
        boolean erro = true; //controle de entrada/erro

        for(String c : v){
            expressao.add(c);

            
            if( erro){//se ja ta errado nao precisa entrar novamente
                
            if(")".equals(c) || "]".equals(c)  || "}".equals(c)) // para fazer as operaçoes quando for igual c for igual
            {
                if(tamanho < p.size()){tamanho = p.size();}

                String n1 = p.pop(); //primeiro inteiro da operacao
                String operador = p.pop();
                String n2 = p.pop(); //segundo inteiro da operaçao
                String abriu = p.pop(); // abriu a expressao
                String h = fechado(c); //converte para o par de c

                // a ordem a seguir importa para poder especificar os possiveis problemas
                try
                {
                double numero1 = Double.parseDouble(n1);//converte a String n1, para double
                try{
                    double numero2 = Double.parseDouble(n2);//converte a String n2, para double

                if(abriu.equals(fechado(c))) // verifica se abre e fecha a expressao corretamente
                {


                    switch (operador)
                        {
                            case "+" :resultado = (numero2+numero1); p.push(String.valueOf ( resultado)); break;
                        case "-" :resultado = (numero2-numero1); p.push(String.valueOf ( resultado)); break; 
                        case "*" :resultado = (numero2*numero1); p.push(String.valueOf ( resultado)); break;
                        case "/" :resultado = (numero2/numero1); p.push(String.valueOf (resultado)); break;
                        case "^" :resultado = (Math.pow(numero2,numero1)); p.push(String.valueOf (resultado)); break;
                        default: System.out.println("Oi Erro no operador "+ operador); break; 
                        }
    
    
                } 
                    else {
                    while(!p.isEmpty()){// especificando o problema
                        if(abriu.equals("{")||abriu.equals("[")||abriu.equals("("))
                        {
                            if(abriu.equals(h))
                            {
                            System.out.println("Erro de sintaxe: abriu "+ abriu + " mas não fechou "); 
                            }
                            else { 
                                System.out.println("Erro de sintaxe: "+ c + " no lugar de "+ abriu2(abriu)); }
                                p.clear();//zerando para sair do while
                            }

                        else{   abriu = p.pop();    }
                        }
                        erro = false;
                    }
                }                 
                catch(NumberFormatException ex)
                {
                System.out.println("  Erro de sintaxe:" + n2 + " no lugar de um inteiro " );
                erro = false;
                }
                }  catch(NumberFormatException ex)
                    {
                    System.out.println("Erro de sintaxe: "+ n1 + " no lugar de um inteiro ");
                        erro = false;
                    }
                        
            
            }else { p.push(c);}// adiciona na pilha
            }

            

            if("}".equals(c) && erro == true) // } final da expressao, serve para reiniciar tudo a apresentar os resultados
            {
                for(int i = 0; i<expressao.size(); i++){
                    System.out.print(expressao.get(i));//imprime a expressao
                }

                System.out.println("\nResultado: "+ resultado);
                System.out.println("Tamanho máximo da pilha: "+ tamanho + " ");
                
                //zera para um novo ciclo
                expressao.clear();
                p.clear();
                tamanho = 0;
                erro = true;
            }
            else if("}".equals(c)) // caso aparecer algum erro quando cheagar no final da expressao zera par que ocorra um novo ciclo
            {
                for(int i = 0; i<expressao.size(); i++){
                    System.out.print(expressao.get(i));//imprime a expressao
                }
                System.out.println();

                //zera para um novo ciclo
                expressao.clear();
                p.clear();
                tamanho = 0;
                erro = true;
            }
            
                
        }

    }  

}