package br.com.gmauricio.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name ="pedido")
public class Pedido implements BaseEntity {

	private static final long serialVersionUID = 1L;
	
	public enum StatusPedido {
		W("AGUARDANDO"), A("APROVADO"), E("ENTREGUE");
		private String nome;
		
		private StatusPedido(String nome){
			this.nome = nome;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		
	}

	private Long id;
	private StatusPedido statusPedido;
	private String nome;
	private Double valor;
	private LocalDate dataEntrega;
	private String urlProduto;
	private String urlImagem;
	private String descricao;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Enumerated(EnumType.STRING)
	public StatusPedido getStatusPedido() {
		return statusPedido;
	}
	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}
	
	@Column(name = "nome")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "valor")
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	@Column(name = "data_entrega")
	public LocalDate getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	
	@Column(name ="url_produto")
	public String getUrlProduto() {
		return urlProduto;
	}
	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	
	@Column(name = "url_imagem")
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	
	@Column(name = "descricao")
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
