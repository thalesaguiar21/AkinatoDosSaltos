from Predicao import *

class TwoLevelAdaptive(Predicao):

	''' Implementaçãode um algoritmo de predição de dois níveis '''

	def __init__(self):
		Predicao.__init__(self)
		tabelaDeHistoricos = {'TT' : 'T', 'TN' : 'T', 'NT' : 'T', 'NN' : 'T'}

