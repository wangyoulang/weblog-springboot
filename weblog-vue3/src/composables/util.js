import { ElMessage } from "element-plus";
import 'element-plus/es/components/message/style/css'

export function showMessage(message = '提示内容', type = 'success', custonClass = '') {
    return ElMessage({
        type: type,
        message: message,
        custonClass,
    })
}