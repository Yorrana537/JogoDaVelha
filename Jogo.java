
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Jogo extends JFrame {
    
    JButton[] botao = new JButton[9];
    JLabel placar = new JLabel("PLACAR");
    JLabel px = new JLabel("X: 0");
    JLabel po = new JLabel("O: 0");
    JButton novo = new JButton("NOVO JOGO");
    JButton zerar = new JButton("ZERAR PLACAR");
    int PX = 0;
    int PO = 0;
    boolean xo = false; 
    boolean[] clique = new boolean[9];
    
    public Jogo(){
        //JANELA VISÍVEL
        setVisible(true);
        //TÍTULO DA JANELA
        setTitle("Jogo da Velha");
        //A JANELA IRÁ SER FECHADA AO CLICAR NO 'X'
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //TAMANHO DA JANELA
        setBounds(250,100,700,500);
        add(placar);
        add(px);
        add(po);
        add(novo);
        add(zerar);
        placar.setBounds(425,50,100,30);
        px.setBounds(410,80,100,30);
        po.setBounds(490,80,100,30);
        novo.setBounds(500,360,140,30);
        zerar.setBounds(500,410,140,30);
        placar.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
        px.setFont(new Font("Arial", Font.BOLD, 15));
        po.setFont(new Font("Arial", Font.BOLD, 15));
        
         novo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpar();
                
            }
        });
         
          zerar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PO = 0;
                PX = 0;
                atualizar();
                
            }
        });
        
        int contagem = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botao[contagem] = new JButton();
                add(botao[contagem]);
                botao[contagem].setBounds((100 * i) + 50,(100 * j) + 50, 95,95);
                botao[contagem].setFont(new Font("Arial", Font.BOLD, 40));
                contagem++;
            }
        }
        
        for (int i = 0; i < 9; i++) {
            clique[i] = false;
        }
         botao[0].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //EVENTO QUE VAI ACONTECER COM O BOTÃO
                if (clique[0] == false) {
                    clique[0] = true;
                    mudar(botao[0]);
                }
                
            }
        });
        
        botao[1].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //EVENTO QUE VAI ACONTECER COM O BOTÃO
                if (clique[1] == false) {
                    clique[1] = true;
                    mudar(botao[1]);
                }
                
            }
        });
        
         botao[2].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //EVENTO QUE VAI ACONTECER COM O BOTÃO
                if (clique[2] == false) {
                    clique[2] = true;
                    mudar(botao[2]);
                }
                
            }
        });
         
          botao[3].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //EVENTO QUE VAI ACONTECER COM O BOTÃO
                if (clique[3] == false) {
                    clique[3] = true;
                    mudar(botao[3]);
                }
                
            }
        });
          
           botao[4].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //EVENTO QUE VAI ACONTECER COM O BOTÃO
                if (clique[4] == false) {
                    clique[4] = true;
                    mudar(botao[4]);
                }
                
            }
        });
           
            botao[5].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //EVENTO QUE VAI ACONTECER COM O BOTÃO
                if (clique[5] == false) {
                    clique[5] = true;
                    mudar(botao[5]);
                }
                
            }
        });
            
             botao[6].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //EVENTO QUE VAI ACONTECER COM O BOTÃO
                if (clique[6] == false) {
                    clique[6] = true;
                    mudar(botao[6]);
                }
                
            }
        });
             
              botao[7].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //EVENTO QUE VAI ACONTECER COM O BOTÃO
                if (clique[7] == false) {
                    clique[7] = true;
                    mudar(botao[7]);
                }
                
            }
        });
              
               botao[8].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //EVENTO QUE VAI ACONTECER COM O BOTÃO
                if (clique[8] == false) {
                    clique[8] = true;
                    mudar(botao[8]);
                }
                
            }
        });
    }
    
    public void mudar(JButton btn){
        if (xo) {
            btn.setText("O");
            xo = false;
            px.setFont(new Font("Arial", Font.BOLD, 15));
        }else{
            btn.setText("X");
            xo = true;
            po.setFont(new Font("Arial", Font.BOLD, 15));
        }
        ganhou();
    
    }
    
    public void atualizar(){
        px.setText("X: " +PX);
        po.setText("O: " +PO);
    }
    
    public void ganhou(){
       
        
        //IRÁ CONTAR QUANTOS BOTÕES FORAM CLICADOS
        int cont = 0;
        for (int i = 0; i < 9; i++) {
            if(clique[i] == true){
                cont++;
            }
        }
        //FORMAS DE GANHAR
        if ((botao[0].getText() == "X" && botao[1].getText() == "X" && botao[2].getText() == "X" )||
                (botao[3].getText() == "X" && botao[4].getText() == "X" && botao[5].getText() == "X" )||
                (botao[6].getText() == "X" && botao[7].getText() == "X" && botao[8].getText() == "X" )||
                (botao[0].getText() == "X" && botao[3].getText() == "X" && botao[6].getText() == "X" )||
                (botao[1].getText() == "X" && botao[4].getText() == "X" && botao[7].getText() == "X" )||
                (botao[2].getText() == "X" && botao[5].getText() == "X" && botao[8].getText() == "X" )||
                (botao[0].getText() == "X" && botao[4].getText() == "X" && botao[8].getText() == "X" )||
                (botao[2].getText() == "X" && botao[4].getText() == "X" && botao[6].getText() == "X" )){
            JOptionPane.showMessageDialog(null, "X ganhou");
            PX++;
            atualizar();
            limpar();
            
        }
        
        else if ((botao[0].getText() == "O" && botao[1].getText() == "O" && botao[2].getText() == "O" )||
                (botao[3].getText() == "O" && botao[4].getText() == "O" && botao[5].getText() == "O" )||
                (botao[6].getText() == "O" && botao[7].getText() == "O" && botao[8].getText() == "O" )||
                (botao[0].getText() == "O" && botao[3].getText() == "O" && botao[6].getText() == "O" )||
                (botao[1].getText() == "O" && botao[4].getText() == "O" && botao[7].getText() == "O" )||
                (botao[2].getText() == "O" && botao[5].getText() == "O" && botao[8].getText() == "O" )||
                (botao[0].getText() == "O" && botao[4].getText() == "O" && botao[8].getText() == "O" )||
                (botao[2].getText() == "O" && botao[4].getText() == "O" && botao[6].getText() == "O" )){
            JOptionPane.showMessageDialog(null, "O ganhou");
            PO++;
            atualizar();
            limpar();
            
        }else if(cont == 9){
            JOptionPane.showMessageDialog(null, "VELHA");
            limpar();
        }
        
        
    
    }
    
    public void limpar(){
        for (int i = 0; i < 109; i++) {
            botao[i].setText("");
            clique[i] = false;
            xo = false;
        }
        
    }
    
    public static void main(String[] args) {
        new Jogo();
    }
}
