import { motion } from 'framer-motion'
import { useQuery } from '@tanstack/react-query'
import axios from 'axios'

function Finance() {
  const { data: transactions, isLoading } = useQuery(['transactions'], async () => {
    const response = await axios.get('/api/finance/transactions')
    return response.data
  })

  return (
    <div className="space-y-6">
      <h1 className="text-2xl font-semibold text-gray-900">Financeiro</h1>
      
      <div className="grid grid-cols-1 gap-5 sm:grid-cols-2 lg:grid-cols-3">
        <motion.div
          initial={{ opacity: 0, y: 20 }}
          animate={{ opacity: 1, y: 0 }}
          className="bg-white overflow-hidden shadow rounded-lg"
        >
          <div className="p-5">
            <h3 className="text-lg font-medium text-gray-900">Saldo Atual</h3>
            <p className="mt-2 text-3xl font-bold text-green-600">R$ 125.000,00</p>
          </div>
        </motion.div>

        <motion.div
          initial={{ opacity: 0, y: 20 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ delay: 0.1 }}
          className="bg-white overflow-hidden shadow rounded-lg"
        >
          <div className="p-5">
            <h3 className="text-lg font-medium text-gray-900">Receitas do Mês</h3>
            <p className="mt-2 text-3xl font-bold text-blue-600">R$ 45.000,00</p>
          </div>
        </motion.div>

        <motion.div
          initial={{ opacity: 0, y: 20 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ delay: 0.2 }}
          className="bg-white overflow-hidden shadow rounded-lg"
        >
          <div className="p-5">
            <h3 className="text-lg font-medium text-gray-900">Despesas do Mês</h3>
            <p className="mt-2 text-3xl font-bold text-red-600">R$ 32.000,00</p>
          </div>
        </motion.div>
      </div>

      <div className="bg-white shadow rounded-lg">
        <div className="px-4 py-5 sm:p-6">
          <h2 className="text-lg font-medium text-gray-900">Últimas Transações</h2>
          {isLoading ? (
            <div className="mt-4 text-center text-gray-500">Carregando...</div>
          ) : (
            <div className="mt-4">
              <div className="flow-root">
                <ul role="list" className="-my-5 divide-y divide-gray-200">
                  {transactions?.map((transaction) => (
                    <motion.li
                      key={transaction.id}
                      initial={{ opacity: 0 }}
                      animate={{ opacity: 1 }}
                      className="py-4"
                    >
                      <div className="flex items-center space-x-4">
                        <div className="flex-1 min-w-0">
                          <p className="text-sm font-medium text-gray-900 truncate">
                            {transaction.description}
                          </p>
                          <p className="text-sm text-gray-500">
                            {new Date(transaction.date).toLocaleDateString()}
                          </p>
                        </div>
                        <div className={`text-sm font-medium ${
                          transaction.type === 'income' ? 'text-green-600' : 'text-red-600'
                        }`}>
                          {transaction.type === 'income' ? '+' : '-'} R$ {transaction.amount.toFixed(2)}
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

export default Finance 