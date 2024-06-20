import { ElMessage } from "element-plus";

export function showMessage(message = "提示内容", type = 'success', custonClass = '') {
    return ElMessage({
        type: type,
        message: message,
        custonClass,
    })
}