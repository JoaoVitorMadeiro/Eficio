import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { motion } from 'framer-motion'
import { useButton } from '@react-aria/button'
import { useRef } from 'react'

function Navbar() {
  const navigate = useNavigate()
  const [isMenuOpen, setIsMenuOpen] = useState(false)
  const buttonRef = useRef()
  const { buttonProps } = useButton({
    onPress: () => setIsMenuOpen(!isMenuOpen)
  }, buttonRef)

  return (
    <nav className="bg-white shadow-lg" role="navigation" aria-label="Main navigation">
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div className="flex justify-between h-16">
          <div className="flex">
            <div className="flex-shrink-0 flex items-center">
              <motion.button
                whileHover={{ scale: 1.05 }}
                whileTap={{ scale: 0.95 }}
                className="text-2xl font-bold text-indigo-600"
                onClick={() => navigate('/')}
                aria-label="Go to home page"
              >
                Eficio
              </motion.button>
            </div>
          </div>

          <div className="flex items-center">
            <button
              ref={buttonRef}
              {...buttonProps}
              className="inline-flex items-center justify-center p-2 rounded-md text-gray-400 hover:text-gray-500 hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-inset focus:ring-indigo-500"
              aria-expanded={isMenuOpen}
            >
              <span className="sr-only">Open main menu</span>
              <svg
                className="h-6 w-6"
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
                aria-hidden="true"
              >
                <path
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  strokeWidth={2}
                  d="M4 6h16M4 12h16M4 18h16"
                />
              </svg>
            </button>
          </div>
        </div>
      </div>

      <motion.div
        initial={false}
        animate={{ height: isMenuOpen ? 'auto' : 0 }}
        className="overflow-hidden"
      >
        <div className="px-2 pt-2 pb-3 space-y-1 sm:px-3">
          <motion.button
            whileHover={{ scale: 1.02 }}
            whileTap={{ scale: 0.98 }}
            className="block w-full text-left px-3 py-2 rounded-md text-base font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50"
            onClick={() => navigate('/finance')}
          >
            Financeiro
          </motion.button>
          <motion.button
            whileHover={{ scale: 1.02 }}
            whileTap={{ scale: 0.98 }}
            className="block w-full text-left px-3 py-2 rounded-md text-base font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50"
            onClick={() => navigate('/sales')}
          >
            Vendas
          </motion.button>
          <motion.button
            whileHover={{ scale: 1.02 }}
            whileTap={{ scale: 0.98 }}
            className="block w-full text-left px-3 py-2 rounded-md text-base font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50"
            onClick={() => navigate('/stock')}
          >
            Estoque
          </motion.button>
          <motion.button
            whileHover={{ scale: 1.02 }}
            whileTap={{ scale: 0.98 }}
            className="block w-full text-left px-3 py-2 rounded-md text-base font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50"
            onClick={() => navigate('/invoice')}
          >
            Notas Fiscais
          </motion.button>
        </div>
      </motion.div>
    </nav>
  )
}

export default Navbar 