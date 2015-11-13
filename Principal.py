from Predicao import *
from PredicaoDeUmBit import *
from PredicaoDeDoisBits import *
from PredicaoMisteriosa import *
from TwoLevelAdaptive import *
from FabricaDePredicoes import *
from Reader import *

class Principal(object):

	def __init__(self):
		self.listaDePreditores = []
		self.listaDeSaltos = ''
		self.reader = Reader()
		self.adicionarPreditores()


	def adicionarPreditores(self):
		counter = 1
		while(counter <= 4):
			self.listaDePreditores.append(criarPreditor(counter))
			counter += 1


	def adicionarSaltos(self, caminhoDoArquivoEntrada):
		self.listaDeSaltos = self.reader.read()


	def executarPredicoes(self, caminhoDoArquivoEntrada):
		self.adicionarPreditores(caminhoDoArquivoEntrada)
		for linha in self.listaDeSaltos:
			print('Saltos da iteração: \t' + linha)
			for preditor in self.listaDePreditores:
				preditor.predizer(linha)
				preditor.exibirResultados()
			print('-------------------------------------------------------------')




myPredictions = Principal()
myPredictions.executarPredicoes('teste.txt')
