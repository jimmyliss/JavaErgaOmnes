package edu.fae.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import edu.fae.dao.CategoriaDao;
import edu.fae.dao.DaoFactory;
import edu.fae.dao.ItemDao;
import edu.fae.dao.ProdutoDao;
import edu.fae.model.CarrinhoCompra;
import edu.fae.model.Imagem;
import edu.fae.model.Item;
import edu.fae.model.Categoria;
import edu.fae.model.Model;
import edu.fae.model.Produto;
import edu.fae.util.DualListModelDiff;
import edu.fae.util.IOUtil;
import edu.fae.util.ThumbnailHelper;

@ViewScoped
@ManagedBean(name="produtoFormController")
public class ProdutoFormController extends AbstractFormController<Produto, ProdutoDao> {
	private CategoriaDao categoriaDao = DaoFactory.getCategoriaDao();
	
	/**
	 * Este m�todo � chamado quando a p�gina do formul�rio � aberta
	 */
	@PostConstruct
	public void iniciar() {
		super.iniciar();
	}
	
	
	public List<Categoria> getCategorias() {
		return categoriaDao.findAll();
	}
	
	private UploadedFile fileImagemChamada;

	public Object getFileImagemChamada() {
		return fileImagemChamada;
	}
	public void setFileImagemChamada(Object obj) {
		if(obj instanceof UploadedFile) {
			this.fileImagemChamada = (UploadedFile) obj;
		}else{
			this.fileImagemChamada = null;
		}
	}
	
	@Override
	public void salvar() {
		//Antes de salvar verifica o upload do arquivo
		//Verifica se o arquivo foi enviado pelo usu�rio
		if(fileImagemChamada!=null) {
			
			//Grava na propriedade imagemChamada o nome do arquivo
			getModel().setImagemChamada(fileImagemChamada.getFileName());
			
			try {
				//Pega o caminho real no servidor da pasta imagens do projeto
				String caminhoImagens = getRealServerPath("/imagens");
				
				
				//Salva o arquivo na pasta imagens do projeto
				FileOutputStream fout = new FileOutputStream(caminhoImagens + 
							File.separator + fileImagemChamada.getFileName());
				
				//Gera uma imagem do tamanho exato 150x150
				ThumbnailHelper.gerarTamanhoExato(fileImagemChamada.getInputstream(), 
													fout, 150, 150, 90, false);
				
				//Gera uma imagem do tamanho exato 150x150 e em preto e branco
//				ThumbnailHelper.gerarTamanhoExato(fileImagemChamada.getInputstream(), 
//						fout, 150, 150, 90, false);				
				
				//Gera uma imagem de tamanho proprocional, colocando ou a altura ou largura em 150px
//				ThumbnailHelper.gerarProprocional(fileImagemChamada.getInputstream(), 
//						fout, 150, 150, 90, false);							
				
				//IOUtil.copyStream(fileImagemChamada.getInputstream(), fout);
				
			} catch (Exception e) {
				System.out.println("Ocorreu um erro ao salvar o arquivo do upload");
				throw new RuntimeException(e);
			}
			
		}
		
		//Chama o salvar da classe ancestral
		super.salvar();
	}
    

    
	/**
	 * Chamado em cada upload de arquivo
	 */
	public void uploadGaleria(FileUploadEvent event) {
		try {
			
			//Pega o caminho real no servidor da pasta imagens do projeto
			String caminhoImagens = getRealServerPath("/imagens");
			
			//Salva o arquivo na pasta imagens do projeto
			FileOutputStream fout = new FileOutputStream(caminhoImagens 
						+ File.separator + event.getFile().getFileName());
			IOUtil.copyStream(event.getFile().getInputstream(), fout);
			
			//Cria uma nova imagem e adiciona no produto
			Imagem imagem = new Imagem();
			//Seta o nome do arquivo na imagem
			imagem.setArquivo(event.getFile().getFileName());
			//Adiciona a imagem no produto
			getModel().getImagens().add(imagem);
			
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao salvar o arquivo do upload");
			throw new RuntimeException(e);
		}			
		
	}	

	/**
	 * Retorna o caminho no servidor onde se encontra o projeto
	 * @return
	 */
	private String getRealServerPath(String caminhoRelativo) {
		return FacesContext.getCurrentInstance().getExternalContext().getRealPath(caminhoRelativo);
	}
	
	private Item itemParaRemover;
	//private ItemDao itemDao = DaoFactory.getItemDao();
	
	public void adicionarItem() {
		Item item = new Item();
		//item.setProduto(getModel());
		
		getModel().getItens().add(item);
	}
	
	public void removerItem() {
		if(itemParaRemover!=null) {
			getModel().getItens().remove(itemParaRemover);
		}
	}
	
	public Item getItemParaRemover() {
		return itemParaRemover;
	}

	public void setItemParaRemover(Item itemParaRemover) {
		this.itemParaRemover = itemParaRemover;
	}
	
/*######################################Carrinho de Compra############################################*/
	
	public void adicionarItemCarrinho(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		
		getCarrinhoSession().adicionarProduto(getModel());

		// Mandando uma mensagem para a tela
		ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Adicionado ao carrinho com sucesso!", null));
	}
}
