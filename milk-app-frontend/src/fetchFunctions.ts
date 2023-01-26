export async function fetchFunctions(page = 0, type='', query='') {
  const res = await fetch(`http://localhost:8080/milkapi/products?page=${page}&type=${type}&query=${query}`)

  if (!res.ok) throw new Error(res.status.toString());
  return res.json()
}

export const getProductData = async(productId: string) => {
  const res = await fetch(`http://localhost:8080/milkapi/products/${productId}`)
  if (!res.ok) throw new Error('Failed to fetch data');
  return res.json()
}

export const getProductTypes = async () => {
  const res = await fetch(`http://localhost:8080/milkapi/products/types`)
  if (!res.ok) throw new Error('Failed to fetch data');
  return res.json()
}