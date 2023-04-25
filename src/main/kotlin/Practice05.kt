/*  람다 함수 기본
fun sum1(no1: Int, no2: Int): Int {                                                                                     // 일반 함수 선언
    return no1 + no2
}
val sum2 = {no1: Int, no2: Int -> no1 + no2 }                                                                           // 람다 함수 선언
fun main() {
    println("sum1 : ${sum1(10, 20)}")                                                                                   // 일반 함수 호출
    println("sum2 : ${sum2(20, 30)}")                                                                                   // 람다 함수 호출
}
 */
/*  매개변수가 없는 람다 함수
val call1 = {-> println("function call1")}                                                                              // 매개변수가 없는 람다 함수
val call2 = {println("function call2")}                                                                                 // 화살표 마저 없는 람다 함수
fun main() {
    call1()
    call2()
    // call1과 call2는 람다 '함수' 이므로 println("$call1")이 아닌 걍 함수 호출 (변수라고 착각하면 안됨)
}
 */
/*  매개변수가 1개인 람다 함수 (it 키워드)
fun main() {
    val some1 = {no: Int -> println(no)}                                                                                // 일반적인 람다 함수
    some1(10)

    val some2: (Int) -> Unit = {println(it)}                                                                            // 매개변수가 1개일 경우 it 키워드 사용가능
    some2(20)
}
 */
/*  람다 함수의 반환
val some1 = {no1: Int, no2: Int -> return no1 * no2}                                                                    // 람다함수에서는 return 키워드 사용 불가
val some2 = {no1: Int, no2: Int ->                                                                                      // 람다함수의 본문이 여러줄일 경우
    println("in some2 lambda function")
    no1 * no2                                                                                                           // "마지막 줄"이 반환값
}
fun main() {
    println("return : ${some2(10, 20)}")
}
 */
/*  람다 함수 타입 선언
fun some1(no1: Int, no2: Int): Int {                                                                                    // 일반적인 함수, 함수타입 선언
    return no1 + no2
}
val some2: (Int, Int) -> Int = {no1: Int, no2: Int -> no1 + no2}                                                        // 람다 함수, 함수타입 선언
 */
/*  타입 별칭
typealias MyInt = Int                                                                                                   // 변수타입 별칭
typealias MyFunType = (Int, Int) -> Boolean                                                                             // 함수타입 별칭

fun main() {
    val data1: Int = 10
    val data2: MyInt = 10                                                                                               // data2를 Int로 선언
    val someFun: MyFunType = {no1: Int, no2: Int ->                                                                     // 람다 함수를 별칭으로 타입선언
        no1 > no2                                                                                                       // 마지막 줄이 반환 값
    }
    println("data1: $data1, data2: $data2")
    println(someFun(10, 20))
    println(someFun(20, 10))
}
 */
/*  람다 함수 매개변수 타입 생략
typealias MyFunType = (Int, Int) -> Boolean                                                                             // 함수 타입 별칭 생성
val someFun1: MyFunType = {no1, no2 ->                                                                                  // 별칭 이용 + 매개변수 타입 생략
    no1 > no2
}
val someFun2: (Int, Int) -> Boolean = {no1, no2 ->                                                                      // 매개변수 타입 생략
    no1 > no2
}
fun main() {
    someFun1(10, 20)
    someFun2(20, 10)
}
 */
/*  고차 함수
fun hofFun(arg: (Int) -> Boolean): () -> String {                                                                       // hofFun은 일반 함수, arg는 람다 함수
    val result = if(arg(10)) {
        "valid"
    } else {
        "invalid"
    }
    return{"hofFun result : $result"}
}
fun main() {
    val result = hofFun({no -> no > 0})
    println(result())
}
 */
/*  널 안정성 1
fun main() {
    var data: String? = null
    var length = if (data == null) {                                                                                    // 값이 null일 경우 오류발생을 대비하여 작성
        0
    } else {
        data.length
    }
    println("data length: $length")
}
 */
/*  널 안정성 2
fun main() {
    var data: String? = null
    println("data length: ${data?.length ?: 0}")                                                                        // 널 안정성 연산자 (엘비스 연산자 "?:")
}
 */
/*  널 안정성 3
fun some(data: String?) : Int {
    return data!!.length                                                                                                // data에 null이 들어올 경우 오류가 아닌 예외처리
}
fun main() {
    println(some("yyj"))
    println(some(null))
}
 */