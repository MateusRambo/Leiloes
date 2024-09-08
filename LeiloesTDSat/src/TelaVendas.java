import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class TelaVendas extends JFrame {

    private JTable tabelaVendas;
    
    public TelaVendas() {
        setTitle("Tela de Vendas");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JScrollPane scrollPane = new JScrollPane();
        tabelaVendas = new JTable();
        tabelaVendas.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{"ID", "Nome", "Valor", "Status"}
        ));
        scrollPane.setViewportView(tabelaVendas);

        add(scrollPane);
        carregarProdutosVendidos();
    }

    private void carregarProdutosVendidos() {
        ProdutosDAO dao = new ProdutosDAO();
        ArrayList<ProdutosDTO> listaVendidos = dao.listarProdutosVendidos();

        DefaultTableModel model = (DefaultTableModel) tabelaVendas.getModel();
        model.setRowCount(0);  // Limpa a tabela

        for (ProdutosDTO produto : listaVendidos) {
            model.addRow(new Object[]{
                produto.getId(),
                produto.getNome(),
                produto.getValor(),
                produto.getStatus()
            });
        }
    }
}
