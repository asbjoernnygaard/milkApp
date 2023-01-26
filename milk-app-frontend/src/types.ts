export interface Product {
  id: string
  name: string
  type: string
  storage: number
}

export interface ProductListResponse {
  products: Product[]
  pageSize: number
  totalPages: number
  totalElements: number
  numberOfElements: number
  first: boolean
  last: boolean
}