"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.valeController = void 0;
const database_1 = __importDefault(require("../database"));
class ValeController {
    list(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            yield database_1.default.query('SELECT * FROM objetivos', function (err, result, fields) {
                if (err)
                    throw err;
                res.json(result);
            });
        });
    }
    getOne(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            const id = req.params.id;
            yield database_1.default.query('SELECT * FROM objetivos WHERE id=?', [id], function (err, result, fields) {
                if (err)
                    throw err;
                if (result.length > 0) {
                    return res.json(result[0]);
                }
                res.status(404).json({ message: "El Objetivo no existe" });
            });
        });
    }
    create(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            yield database_1.default.query('INSERT INTO objetivos set ?', [req.body]);
            res.json({ message: 'Objetivo creado' });
        });
    }
    delete(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            const id = req.params;
            yield database_1.default.query('DELETE FROM objetivos WHERE id=?', [id], function (err, result, fields) {
                if (err)
                    throw err;
                res.json({ message: "El Objetivo fue eliminado" });
            });
        });
    }
    update(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            const id = req.params;
            yield database_1.default.query('UPDATE objetivos set ? WHERE id=?', [req.body, id], function (err, result, fields) {
                if (err)
                    throw err;
                res.json({ message: "El Objetivo fue actualizado" });
            });
        });
    }
    getUser(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            const { user } = req.params;
            const { password } = req.params;
            yield database_1.default.query('SELECT username FROM users WHERE username = ? and password = ?', [user, password], function (err, result, fields) {
                if (err)
                    throw err;
                if (result.length > 0) {
                    return res.json(1);
                }
                else {
                    return res.json(0);
                }
            });
        });
    }
}
exports.valeController = new ValeController();
