package data

object CartItems { //프로젝트 전역에서 상품 데이터를 저장하는 클래스이므로 항상 같은 값이 유지되어야 함(싱글턴 객체)
    //map 사용하는 이유 : 수량정보도 저장하려고 (private으로 외부에서는 원소 수정 X)
    private val mutableProducts = mutableMapOf<Product, Int>()
    val products: Map<Product, Int> = mutableProducts //외부 공개, immutable read-only

    fun addProduct(product: Product) {
        mutableProducts[product]?.let {
            mutableProducts[product] = it + 1
        } ?: kotlin.run {
            mutableProducts[product] = 1
        }
    }
}