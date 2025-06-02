import { motion } from 'framer-motion'
import { useQuery } from '@tanstack/react-query'
import axios from 'axios'

function Stock() {
  const { data: products, isLoading } = useQuery(['products'], async () => {
    const response = await axios.get('/api/stock/products')
    return response.data
  })

  return (
    <div className="space-y-6">
      <div className="flex justify-between items-center">
        <h1 className="text-2xl font-semibold text-gray-900">Estoque</h1>
        <motion.button
          whileHover={{ scale: 1.02 }}
          whileTap={{ scale: 0.98 }}
          className="btn btn-primary"
        >
          Novo Produto
        </motion.button>
      </div>

      <div className="grid grid-cols-1 gap-5 sm:grid-cols-2 lg:grid-cols-3">
        <motion.div
          initial={{ opacity: 0, y: 20 }}
          animate={{ opacity: 1, y: 0 }}
          className="bg-white overflow-hidden shadow rounded-lg"
        >
          <div className="p-5">
            <h3 className="text-lg font-medium text-gray-900">Total de Produtos</h3>
            <p className="mt-2 text-3xl font-bold text-indigo-600">1.234</p>
            <p className="mt-1 text-sm text-gray-500">Em 45 categorias</p>
          </div>
        </motion.div>

        <motion.div
          initial={{ opacity: 0, y: 20 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ delay: 0.1 }}
          className="bg-white overflow-hidden shadow rounded-lg"
        >
          <div className="p-5">
            <h3 className="text-lg font-medium text-gray-900">Produtos com Baixo Estoque</h3>
            <p className="mt-2 text-3xl font-bold text-red-600">23</p>
            <p className="mt-1 text-sm text-red-600">Precisam de reposição</p>
          </div>
        </motion.div>

        <motion.div
          initial={{ opacity: 0, y: 20 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ delay: 0.2 }}
          className="bg-white overflow-hidden shadow rounded-lg"
        >
          <div className="p-5">
            <h3 className="text-lg font-medium text-gray-900">Valor Total em Estoque</h3>
            <p className="mt-2 text-3xl font-bold text-green-600">R$ 234.567,00</p>
            <p className="mt-1 text-sm text-gray-500">Média de R$ 190,00 por item</p>
          </div>
        </motion.div>
      </div>

      <div className="bg-white shadow rounded-lg">
        <div className="px-4 py-5 sm:p-6">
          <h2 className="text-lg font-medium text-gray-900">Produtos com Baixo Estoque</h2>
          {isLoading ? (
            <div className="mt-4 text-center text-gray-500">Carregando...</div>
          ) : (
            <div className="mt-4">
              <div className="flow-root">
                <ul role="list" className="-my-5 divide-y divide-gray-200">
                  {products?.map((product) => (
                    <motion.li
                      key={product.id}
                      initial={{ opacity: 0 }}
                      animate={{ opacity: 1 }}
                      className="py-4"
                    >
                      <div className="flex items-center space-x-4">
                        <div className="flex-1 min-w-0">
                          <p className="text-sm font-medium text-gray-900 truncate">
                            {product.name}
                          </p>
                          <p className="text-sm text-gray-500">
                            Código: {product.code}
                          </p>
                        </div>
                        <div className="flex items-center space-x-2">
                          <span className={`px-2 py-1 text-xs font-medium rounded-full ${
                            product.quantity <= product.minQuantity ? 'bg-red-100 text-red-800' :
                            product.quantity <= product.minQuantity * 1.5 ? 'bg-yellow-100 text-yellow-800' :
                            'bg-green-100 text-green-800'
                          }`}>
                            {product.quantity} unidades
                          </span>
                          <span className="text-sm font-medium text-gray-900">
                            R$ {product.price.toFixed(2)}
                          </span>
                        </div>
                      </div>
                    </motion.li>
                  ))}
                </ul>
              </div>
            </div>
          )}
        </div>
      </div>
    </div>
  )
}

export default Stock 