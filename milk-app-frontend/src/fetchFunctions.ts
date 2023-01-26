export async function fetchFunctions(page = 0, type=new Set<string>(), query='') {
  const uri = generateUriFromQueries(page, query, type)
  const res = await fetch(`http://localhost:8080/milkapi/${uri}`)

  if (!res.ok) throw new Error(res.status.toString());
  return res.json()
}

export const getProductData = async(productId: string) => {
  const res = await fetch(`http://localhost:8080/milkapi/products/${productId}`)
  if (!res.ok) throw new Error('Failed to fetch data');
  return res.json()
}

export const getProductTypes = async () => {
  const res = await fetch('http://localhost:8080/milkapi/products/types')
  if (!res.ok) throw new Error('Failed to fetch data');
  return res.json()
}

export const generateUriFromQueries = (page: number, query: string, types: Set<string>) => {
  const pageParam = 'page=' + page.toString()
  const queryParam = (page?'&':'') + 'query=' + query
  const typesParam = (query?'&':'') + 'types=' + Array.from(types).join(',').replaceAll(' ', '%20')
  return `products?${query ? queryParam : ''}${types.size ? typesParam : ''}`;
}