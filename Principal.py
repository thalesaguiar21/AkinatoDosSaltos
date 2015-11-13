from Predicao import *
from FabricaDePreditores import *
from Reader import *

class Principal(object):

	def __init__(self):
		self.listaDePreditores = []
		self.listaDeSaltos = ''
		self.reader = Reader()
		self.fabrica = FabricaDePreditores()
		self.adicionarPreditores()


	def adicionarPreditores(self):
		counter = 1
		while(counter <= 4):
			self.listaDePreditores.append(self.fabrica.criarPreditor(counter))
			counter += 1


	def adicionarSaltos(self, caminhoDoArquivoEntrada):
		self.listaDeSaltos = self.reader.read(caminhoDoArquivoEntrada)


	def executarPredicoes(self, caminhoDoArquivoEntrada):
		self.adicionarSaltos(caminhoDoArquivoEntrada)
		for linha in self.listaDeSaltos:
			print('Saltos da iteração: \t' + linha)
			print('-------------------------------------------------------------')
			for preditor in self.listaDePreditores:
				preditor.predizer(linha)
				preditor.exibirResultados()
				preditor.reset()
			print('-------------------------------------------------------------')




myPredictions = Principal()
myPredictions.executarPredicoes('teste.txt')
